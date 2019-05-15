mod int_bst;
use int_bst::IntBST;

fn main() {
    let mut bst = IntBST::new();
    bst.add(10); bst.add(15); bst.add(3);
    println!("{:#?}", bst);
}
