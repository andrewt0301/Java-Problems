/*
 * Copyright 2018 AndrewT (https://github.com/andrewt0301)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package ru.andrewt;

/**
 * The {@link TreeNode} class describes a node of a binary search tree.
 *
 * @param <K> Key type (must implement {@link Comparable}).
 * @param <V> Value type.
 *
 * @author Andrei Tatarnikov
 */
public class TreeNode<K extends Comparable<K>, V> {
    public final K key;
    public V value;

    public TreeNode<K,V> p;
    public TreeNode<K,V> left;
    public TreeNode<K,V> right;

    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
