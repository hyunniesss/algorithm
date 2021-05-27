package datastructure;

public class JavaThread extends Thread {

	@Override
	public void run() {
		System.out.println("RUN");
		super.run();
	}

}
