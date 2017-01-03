
class HelloJni {
	public native String print();
	public static void main(String[] args) {
	new HelloJni().print();
	}
	
}