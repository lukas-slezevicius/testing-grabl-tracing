package trace;

import com.vaticle.factory.tracing.client.FactoryTracing;

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
        var root = analysis.trace("the-root", "tracker?", 1);
        Thread.sleep(1000);
        root.end();
    }
}
