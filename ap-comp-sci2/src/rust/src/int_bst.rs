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
        self.addH(x, &self.root);
        self.size += 1;
    }

    fn addH(&mut self, x:isize, rt:&Option<Box<TreeNode>>) -> &Option<Box<TreeNode>> {
        if let Some(node) = rt {
            if x <= (*node).val {
                (*node).left = *self.addH(x, &node.left);
//                Some(Box::new(
//                    TreeNode {
//                        val: x,
//                        left: *self.addH(x, (*node).left),
//                        right: node.right,
//                    }
//                ))
            } else {
                (*node).right = *self.addH(x, &node.right);
//                Some(Box::new(
//                    TreeNode {
//                        val: x,
//                        left: node.left,
//                        right: *self.addH(x, (*node).right),
//                    }
//                ))
            }
            &Some(*node)
        } else {
            &Some(Box::new(TreeNode::new(x)))
        }
    }

    pub fn addI(&mut self, x:isize) {
        let mut leader = &self.root;
        loop {
            if let Some(mut node) = leader {
                if x <= (*node).val {
                    node.left = match &node.left {
                        Some(val) => {
                            leader = &val.left;
                            Some(*val)
                        },
                        None => Some(Box::new(TreeNode::new(x))),
                    }
                } else {
                    leader = &node.right;
                }
            }
        }
        self.size += 1;
    }

    pub fn inorder(&self) {
        self.inorderH(&self.root);
        println!();
    }

    fn inorderH(&self, rt:&Option<Box<TreeNode>>) {
        if let Some(node) = rt {
            self.inorderH(&node.left);
            println!("{} ", node.val);
            self.inorderH(&node.right);
        }

    }

    pub fn preorder(&self) {
        self.preorderH(&self.root);
        println!();
    }

    fn preorderH(&self, rt:&Option<Box<TreeNode>>) {
        if let Some(node) = rt {
            println!("{} ", node.val);
            self.inorderH(&node.left);
            self.inorderH(&node.right);
        }
    }

    pub fn postorder(&self) {
        self.postorderH(&self.root);
        println!();
    }

    fn postorderH(&self, rt:&Option<Box<TreeNode>>) {
        if let Some(node) = rt {
            self.preorderH(&node.left);
            self.preorderH(&node.right);
            println!("{} ", node.val);
        }
    }

    fn remove(&mut self, val:isize) -> bool {
        match &mut self.root {
            Some(node) => {
                let tmp = &mut node;
                removeR(tmp, tmp, &TreeNode::new(val), true)
            },
            None => false,
        }
    }

}

#[derive(Debug, Clone)]
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

    pub fn isLeaf(&self) -> bool {
        match (&self.right, &self.left) {
            (None, None) => true,
            _ => false,
        }
    }
}

fn maxNode(rt:&TreeNode) -> &TreeNode {
    let mut ans = rt;
    loop {
        match &ans.right {
            Some(node) => ans = &*node,
            None => break,
        }
    }
    ans
}

fn minNode(rt:&TreeNode) -> &TreeNode {
    let mut ans = rt;
    loop {
        match &ans.left {
            Some(node) => ans = &*node,
            None => break,
        }
    }
    ans
}

fn remove(root:&TreeNode, target:&TreeNode) -> bool {
    let mut leader = root;
    let mut follower = root;
    let mut isRight = true;
    loop {
        if target.val > leader.val {
            match &leader.right {
                Some(boxed) => {
                    follower = leader;
                    leader = &*boxed;
                    isRight = true;
                    continue;
                },
                None => return false,
            }
        } else if target.val < leader.val {
            match &leader.left {
                Some(boxed) => {
                    follower = leader;
                    leader = &*boxed;
                    isRight = false;
                    continue;
                },
                None => return false,
            }
        } else {
            if isRight {follower.right = None; return true;}
            else {follower.left = None; return true;}
        }
    }
}

fn removeR(prev:&TreeNode, root:&TreeNode, target:&TreeNode, isRight:bool) -> bool {
    if target.val > root.val {
        match &root.right {
            Some(node) => removeR(&root, &*node, target, true),
            None => false,
        }
    } else if target.val < root.val {
        match &root.left {
            Some(node) => removeR(&root, &*node, target, false),
            None => false,
        }
    } else {
        if isRight {prev.right = None;}
        else {prev.left = None;}
        true
    }
}

