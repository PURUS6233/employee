package main.java.employee;

@SuppressWarnings("serial")
public class IncorrectFileFormatException extends Throwable {
	
	public IncorrectFileFormatException(){
		super();
	}
	
	public IncorrectFileFormatException(String data){
		super(data);
	}
	
	public IncorrectFileFormatException(String data, Throwable e){
		super(data,e);
	}

}
