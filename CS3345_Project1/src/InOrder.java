public class InOrder extends ListManager{
	InOrder(int l,String s){
		super(l,s);
		sort();
		copyArr();
		sortAll();
	}
}