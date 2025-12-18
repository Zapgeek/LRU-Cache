# LRU Cache (Java)

## Overview
This project implements a Least Recently Used (LRU) Cache using a combination of a HashMap and a Doubly Linked List to achieve O(1) time complexity for both `get` and `put` operations.

## Features
- Constant time `get` and `put`
- Automatic eviction of least recently used items
- Clean and efficient data structure design

## Design
- **HashMap**: Provides O(1) access to cache entries
- **Doubly Linked List**: Maintains usage order (MRU → LRU)

## Operations
- `get(key)`: Returns the value if present, otherwise -1
- `put(key, value)`: Inserts or updates a key-value pair and evicts LRU if capacity is exceeded

## Time Complexity
- `get`: O(1)
- `put`: O(1)

## Space Complexity
- O(capacity)

## Usage
This is a data-structure implementation and does not include a main method. It is intended to be used as a reusable cache component.
