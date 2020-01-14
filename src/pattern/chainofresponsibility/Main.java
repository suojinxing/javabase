package pattern.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charile = new SpecialSupport("Charile", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        // 形成职责链
        alice.setNext(bob).setNext(charile).setNext(diana).setNext(elmo).setNext(fred);

        for (int i = 0; i < 500; i += 13) {
            alice.support(new Trouble(i));
        }
    }
}
