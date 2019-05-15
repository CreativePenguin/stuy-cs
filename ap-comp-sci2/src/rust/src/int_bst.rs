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

    pub fn add(mut self, x:isize) {
        self.root = self.addH(x, self.root);
        self.size += 1;
    }

    fn addH(&self, x:isize, rt:Option<Box<TreeNode>>) -> Option<Box<TreeNode>> {
        if let Some(node) = rt {
            if x <= (*node).val {
                Some(Box::new(
                    TreeNode {
                        val: x,
                        left: self.addH(x, (*node).left),
                        right: (*node).right,
                    }))
            } else {
                Some(Box::new(
                    TreeNode {
                        val: x,
                        left: (*node).left,
                        right: self.addH(x, (*node).right),
                    }
                ))
            }
        } else {
            Some(Box::new(TreeNode::new(x)))
        }
    }

    pub fn inorder(&self) {
        self.inorderH(self.root);
        println!();
    }

    fn inorderH(&self, rt:Option<Box<TreeNode>>) {
        if let Some(node) = rt {
            self.inorderH(node.left);
            println!("{} ", node.val);
            self.inorderH(node.right);
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

}

