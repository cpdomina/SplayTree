Splay Tree
==========

Top-Down [Splay Tree](http://en.wikipedia.org/wiki/Splay_tree) Java implementation.
Largely based on the implementation by [Danny Sleator](http://www.link.cs.cmu.edu/splay/), available on public domain.
Cleaned & refactored code, added generics, builders, iterator, and a couple of minor performance improvements.

### Usage

	SplayTree<Integer> t = SplayTree.create(1,0,2,4,3);
	
	assert t.findMin() == 0;
	assert t.findMax() == 4;
	assert t.contains(2) == true;
	
	t.insert(5);
	t.remove(1);
	
	for(int i: t) {
		System.out.println(i);
	}