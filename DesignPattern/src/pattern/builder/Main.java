package pattern.builder;

public class Main {

	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.exit(0);
		}
		
		if(args[0].equals("plain")) {
			TextBuilder textbuilder = new TextBuilder();
			Director director = new Director(textbuilder);
			director.construct();
			String result = textbuilder.getResult();
			System.out.println(result);
		} else if(args[0].equals("html")) {
			HTMLBuilder htmlbuilder = new HTMLBuilder();
			Director director = new Director(htmlbuilder);
			director.construct();
			String filename = htmlbuilder.getResult();
			System.out.println(filename + "が作成されました。");
		} else {
			System.exit(0);
		}
		
	}
}
