package woopaca.core.singleton;

public class SingletonService {

    // static 영역에 객체를 하나만 생성해 둔다.
    private static final SingletonService instance = new SingletonService();

    // 외부에서 객체 인스턴스가 필요한 경우 getInstance() 메서드를 통해서만 조회가 가능하다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 외부에서 new 키워드를 사용해 객체를 생성하는 것을 막는다.
    private SingletonService() {}

    public void login() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
