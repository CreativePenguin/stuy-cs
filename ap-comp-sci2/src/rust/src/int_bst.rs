#[derive(Debug)]
pub struct IntBST {
    root: Option<Box<TreeNode>>,
    size: isize,
}

impl IntBST {

    pub fn new() -> IntBST {
        IntBST {
            root: None,
            size: 0,
        }
    }

    pub fn addR(&mut self, x:isize) {
        self.addH(x, self.root);
        self.size += 1;
    }

    fn addH(&self, x:isize, rt:&Option<Box<TreeNode>>) -> &Option<Box<TreeNode>> {
        if let Some(node) = rt {
            if x <= (*node).val {
                Some(Box::new(
                    TreeNode {
                        val: x,
                        left: *self.addH(x, (*node).left),
                        right: node.right,
                    }
                ))
            } else {
                Some(Box::new(
                    TreeNode {
                        val: x,
                        left: node.left,
                        right: *self.addH(x, (*node).right),
                    }
                ))
            }
        } else {
            Some(Box::new(TreeNode::new(x)))
        }
    }
    
    pub fn addI(&mut self, x:isize) {
        let mut leader = self.root;
        while(!leader.isLeaf()) {
            if(x <= leader.val) {
                leader = leader.left;
            } else {
                leader = leader.right;
            }
        }
        if(x <= leader.val) {
            leader.left = TreeNode::new(x);
        } else {
            leader.right = TreeNode::new(x);
        }
        size += 1;
    }

    pub fn inorder(&self) {
        self.inorderH(self.root);
        println!();
    }

    fn inorderH(&self, rt:&Option<Box<TreeNode>>) {
        if let Some(node) = rt {
            self.inorderH(node.left);
            println!("{} ", node.val);
            self.inorderH(node.right);
        }

    }
    
    fn preorder(&self) {
        self.preorderH(self.root);
        println!();
    }
    
    fn preorderH(&self, rt:&Option<Box<TreeNode>>) {
        if let Some(node) = rt {
            println!("{} ", node.val);
            self.inorderH(node.left);
            self.inorderH(node.right);
        }
    }
    
    fn postorder(&self) {
        self.postorderH(self.root);
        println!();
    }
    
    fn preorderH(&self, rt:&Option<Box<TreeNode>>) {
        if let Some(node) = rt {
            self.preorderH(node.left);
            self.preorderH(node.right);
            println!("{} ", node.val);
        }
    }

}

#[derive(Debug)]
struct TreeNode {
    val: isize,
    left: Option<Box<TreeNode>>,
    right: Option<Box<TreeNode>>,
}

impl TreeNode {
    fn new(val:isize) -> TreeNode {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }

    fn isLeaf() -> bool {
        left == None && right == None
    }
}

