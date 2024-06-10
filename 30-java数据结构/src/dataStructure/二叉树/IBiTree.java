package dataStructure.二叉树;

@SuppressWarnings("all")
public interface IBiTree<E> {
	TreeNode<E> create(E val, TreeNode<E>l, TreeNode<E> r);	//以val为根节点元素，l和r为左右子树构造二叉树
	void insertL(E val, TreeNode<E> p);			//将元素插入p的左子树
	void insertR(E val, TreeNode<E> p);			//将元素插入p的右子树
	TreeNode<E> deleteL(TreeNode<E> p) ;			//删除p的左子树
	TreeNode<E> deleteR(TreeNode<E> p);				//删除p的右子树
	Boolean search(TreeNode<E> root, E value) ;	//在root树中查找结点元素为value的结点
	void traverse(TreeNode<E> root);			//按某种方式遍历root二权树
}