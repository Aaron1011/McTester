/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.mctester.junit;

import net.minecraft.launchwrapper.LaunchClassLoader;

import java.util.concurrent.CompletableFuture;

public class RunnerEvents {

    private static CompletableFuture<Void> playerJoined = new CompletableFuture<>();
    private static CompletableFuture<Void> gameClosed = new CompletableFuture<>();
    private static CompletableFuture<LaunchClassLoader> launchClassLoaderFuture = new CompletableFuture<>();

    public static void waitForPlayerJoin() {
        try {
            playerJoined.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setPlayerJoined() {
        playerJoined.complete(null);
    }

    public static boolean hasPlayerJoined() {
        return playerJoined.isDone();
    }

    public static void waitForGameClosed() {
        try {
            gameClosed.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setGameClosed() {
        gameClosed.complete(null);
    }

    public static LaunchClassLoader waitForLaunchClassLoaderFuture() {
        try {
            return launchClassLoaderFuture.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setLaunchClassLoaderFuture(LaunchClassLoader launchClassLoader) {
        launchClassLoaderFuture.complete(launchClassLoader);
    }

}
