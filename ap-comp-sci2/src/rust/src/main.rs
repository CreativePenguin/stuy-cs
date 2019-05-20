mod int_bst;
use int_bst::IntBST;

fn main() {
    let mut bst = IntBST::new();
    bst.addR(10); bst.addR(15); bst.addR(3);
    bst.inorder(); bst.preorder(); bst.postorder();
}
