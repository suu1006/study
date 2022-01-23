package study1;

public class cp1 {

	public static void main(String[] args) {
		Buyer2 b = new Buyer2(); // Buyer2 클래스 / 변수 b 인스턴스 생성
		
		 b.buy(new Tv2());// Tv t = new Tv(); b.buy(t) >> b.buy(new Tv()); 
		 b.buy(new Computer2());// Computer2 
		 b.buy(new Audio2());// Audio2 
		 b.summary();
	}
}
 class Product2 {// Product2 클래스
	int price; //가격
	int bonusPoint; //보너스포인트

	Product2(int price) { // Product2 생성자 (매개변수 : 가격)  / 매개변수가 있는 생성자 -> 기본생성자 만들어줘야함.
		this.price = price; // this 가격 / this.price =인스턴스 변수  / price = 지역변
		bonusPoint = (int)(price/10.0); 
	}// 보너스포인트 가격을 10으로 나눈것을 정수형으로 변환
	 Product2(){}// Product2 기본생성자 
	}
 class Tv2 extends Product2 {// Tv2 클래스 (Product2 상속받음)
	Tv2 () {super(100); }// 조상클래스 생성자 호출 : 100만원으로 설정

	 public String toStirng() {return "Tv";}// toString() 문자열로 만들어 반환 return 값 : tv
}

 class Computer2 extends Product2 { // Computer2 클래스 (상속받음)
	 Computer2 () {super(200); }// 생성자 호출 : 200만원으로 설정
	 public String toStirng () { return "Computer2";}  // Computer2  문자열 반환
}

 class Audio2 extends Product2 { // Audio 클래스 (상속받음)
	 Audio2 () {super(50);}// 50만원으로 설정
	 public String toString () { return "Audio2"; }  // Audio 문자열 반환
}
 
 class Buyer2 { // 구매자2 클래스
	 int money = 1000;// 돈 1000만원으로 초기화
	 int bonusPoint = 0; // 보너스포인트 0점으로 초기화
	 Product2[] cart = new Product2[10]; // Product2 클래스 배열 10개 생성 / 변수이름 cart 
	 int i = 0 ; // Product 배열에 사용될 카운터
	
	 void buy(Product2 p) { // buy 메서드 (매개변수 Product2 타입>> Product 자손타입의 참조변수 모두 가능 p)
		 if (money < p.price) {// 돈이 제품의 가격보다 적으면
			 System.out.println("잔액이 부족하여 구입할 수 없습니다.");// 살 수 없습니다 출력
			 return;//  return : 해당 구문에서 탈출
		 }
		 money -= p.price;//돈에서 제품의 가격만큼 빼기
		 bonusPoint += p.bonusPoint;// 보너스포인트 에서 가격의 보너스 포인트 추가
		cart[i++] = p; // 카트 배열에 물건 담기
		System.out.println( p +"을/를 구입하셨습니다.");// 제품 + 구입하셨습니다 출력
	 }
	 void summary () {// 구매정보 요약 메서드
		 int sum = 0;// sum 변수 0으로 초기화
		 String itemList = "";// 아이템 리스트 ""
		
		 for (int i = 0; i<cart.length; i++) { // for문 0부터 카트 길이까지
			  if (cart[i]==null) break;// cart개수가 없으면 break
			  sum += cart[i].price;// 합계 = 카트의 가격
			 itemList += cart[i] + ",";// 아이템리스트는 카트 + ,
		 }
		 System.out.println("구입하신 물품의 총 금액은" + sum + "입니다.");// 구입하신 물품의 총 금액은 ~ 입니다. 
		 System.out.println("구입하신 제품은 " + itemList + "입니다.");// 구입하신 제품은 ~ 입니다.
		 }
	 }