package org.example.kie.api.testday;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {
    public static final void main(String[] args) {
        try {
            // Load the knowledge base:
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession();

            // Go!

            for (int i = 0; i < 3; i++) {
                Person p = new Person();
                p.setWage(50);
                p.setFirstName("Tom" + i);
                p.setLastName("Summers" + i);
                p.setHourlyRate(10);

                kSession.insert(p);
            }

            int rulesFired = kSession.fireAllRules();
            System.out.println(rulesFired);
            kSession.dispose();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
