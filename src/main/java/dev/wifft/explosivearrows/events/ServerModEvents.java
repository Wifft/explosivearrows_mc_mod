package dev.wifft.explosivearrows.events;

import org.slf4j.Logger;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import com.mojang.logging.LogUtils;

import dev.wifft.explosivearrows.helpers.UserHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.User;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

import net.minecraft.core.Direction;

import net.minecraft.server.MinecraftServer;

import net.minecraft.server.level.ServerLevel;

import net.minecraft.world.entity.player.Player;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ServerModEvents
{
    private static final Logger LOGGER = LogUtils.getLogger();
    
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event)
    {
        User user = Minecraft.getInstance().getUser();

        if (UserHelper.isDev()) {
            MinecraftServer server = event.getServer();
            if (server.isSingleplayerOwner(user.getGameProfile())) {
                ServerLevel level = server.overworld();

                Player player = level.getPlayerByUUID(user.getProfileId());            
                if (player != null) {
                    CommandSourceStack commandSourceStack = server.createCommandSourceStack().withSuppressedOutput();
    
                    try {
                        server.getCommands().getDispatcher().execute(playerParticleCommand(player).getLiteral(), commandSourceStack);
                    } catch (CommandSyntaxException e) {
                        LOGGER.error(e.getMessage());
                    }
                }
            }
        } 
    }

    private static LiteralArgumentBuilder<CommandSourceStack> playerParticleCommand(Player player)
    {
        Direction playerDirection = player.getDirection();
        
        double posOffset = 1.0d;

        double xp = switch (playerDirection) {
            case WEST ->  player.getX() + (posOffset * 3);
            case EAST ->  player.getX() - (posOffset * 3);
            default ->  player.getX();
        };
        double yp = player.getY() - posOffset;
        double zp = switch (playerDirection) {
            case NORTH -> player.getZ() + (posOffset * 3);
            case SOUTH -> player.getZ() - (posOffset * 3);
            default -> player.getZ();
        };
    
        double xd = 1.0d;
        double yd = 0.001d;
        double zd = 1.0d;

        double speed = 0.01d;

        int count = 32;

        String mode = "normal";

        String rawCommand = String.format("particle poof %s %s %s %s %s %s %s %s %s", xp, yp, zp, xd, yd, zd, speed, count, mode);
        return Commands.literal(rawCommand);
    }
}
