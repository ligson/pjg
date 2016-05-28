package org.ligson.pjg.line;

public class 刘元秀  implements Runnable{
	public void 跑(){
		System.out.println("我会跑.....");
	}
	public static void main(String[] args) {
		刘元秀 dog = new 刘元秀();
		dog.跑();
		Thread thread = new Thread(dog);
		thread.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			跑();
		}
	}

}
