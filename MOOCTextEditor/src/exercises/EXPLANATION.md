# Binary Tree

## Binary Tree traversals are:
These two are **"Depth First Traversal"**
* pre-order traversal - when we're going steps: (ABDECFG)
  -  visit myself(root)
  -  visit all left branches
  -  visit all right branches
* post-ordered traversal - doing steps with: (DEBFGCA)
  - visit all left subtrees
  - visit all right subtrees
  - visit root  
  

  
* in-ordered traversal - doing steps with: (DBEAFCG)
  - visit left nodes
  - visit root nodes
  - visit right nodes

* level-ordered traversal (known as **Breadth First search**): (ABCDEFG)
  - create a queue
  - put every "row's" member as visited
  - put his children to queue
    - visit children
  - remove parent from queue


  ```ASCII
          A
         / \
        B   C
       / \  / \
      D   E G   F


Pre-order traversal: A B D E C F G
```
