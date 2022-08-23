package trace;

import com.vaticle.factory.tracing.client.FactoryTracing;

import java.util.concurrent.ThreadLocalRandom;

public class Trace {
    public static void main(String[] args) throws InterruptedException {
        var uri = args[0];
        var token = args[1];
        var owner = args[2];
        var repo = args[3];
        var commit = args[4];
        var name = "my-analysis";
        System.out.println(uri);
        System.out.println(token);
        System.out.println(owner);
        System.out.println(repo);
        System.out.println(commit);
        System.out.println(name);
        var tracing = FactoryTracing.create(uri, owner, token);
        var analysis = tracing.analysis(owner, repo, commit, name);
        for (int i = 0; i < 10; i++) {
            var root = analysis.trace("the-root", "tracker?", i);
            f(root);
            g(root);
            root.end();
        }
    }

    public static void f(FactoryTracing.Trace t) throws InterruptedException {
        var t2 = t.trace("f");
        int randomNum = ThreadLocalRandom.current().nextInt(1, 2000);
        Thread.sleep(randomNum);
        h(t2);
        t2.end();
    }

    public static void h(FactoryTracing.Trace t) throws InterruptedException {
        var t2 = t.trace("h");
        int randomNum = ThreadLocalRandom.current().nextInt(1, 2000);
        Thread.sleep(randomNum);
        t2.end();
    }

    public static void g(FactoryTracing.Trace t) throws InterruptedException {
        var t2 = t.trace("g");
        int randomNum = ThreadLocalRandom.current().nextInt(1, 2000);
        Thread.sleep(randomNum);
        t2.end();
    }
}
