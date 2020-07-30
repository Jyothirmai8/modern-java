package examples.chain.oo;

/*
 * 
 *    O1          ->     O2 
 *   
 *    HeaderText       spell-check
 *    
 *    
 */

abstract class ProcessingObject<T> {
	protected ProcessingObject<T> next;

	public ProcessingObject<T> setNext(ProcessingObject<T> next) {
		this.next = next;
		return next;
	}

	public T handle(T t) {
		T r = handleWork(t);
		if (next != null) {
			return next.handle(r);
		}
		return r;
	}

	abstract protected T handleWork(T t);
}

class HeaderTextProcessingObject extends ProcessingObject<String> {
	@Override
	protected String handleWork(String t) {
		return "From Nag , Title : " + t;
	}
}

class SpellCheckProcessingObject extends ProcessingObject<String> {
	@Override
	protected String handleWork(String t) {
		return t.replaceAll("labda", "lambda");
	}
}

class CaseConvertProcessingObject extends ProcessingObject<String> {
	@Override
	protected String handleWork(String t) {
		return t.toUpperCase();
	}
}

public class ChainOfReponsibilityPattern_Ex {

	public static void main(String[] args) {

		ProcessingObject<String> p1 = new HeaderTextProcessingObject();
		ProcessingObject<String> p2 = new SpellCheckProcessingObject();
		ProcessingObject<String> p3 = new CaseConvertProcessingObject();

		p1.setNext(p2).setNext(p3);

		String result = p1.handle("Functional coding with labdas");
		System.out.println(result);

	}

}
