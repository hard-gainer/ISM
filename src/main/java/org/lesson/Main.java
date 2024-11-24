package org.lesson;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.lesson.entity.Computer;

import java.time.LocalDate;

//Наше приложение будет решать вымышленную задачу, которую можно сформулировать при помощи следующих условий.
//Компания под названием XYZ производит два типа компьютеров: «тип 1» и «тип 2». Тип компьютера определяется его архитектурой.
//Компьютеры фирмы XYZ могут выполнять ряд функций. На данный момент определены четыре функции: сервер DDNS (DDNS Server), сервер DNS (DNS Server), шлюз (Gateway) и маршрутизатор (Router).
//Каждый компьютер перед выпуском проходит ряд тестов.
//Тесты, выполняемые над каждым компьютером, зависят от его типа и выполняемой функции. На данный момент определены пять тестов: «тест 1», «тест 2», «тест 3», «тест 4» и «тест 5».
//Для каждого проверяемого компьютера устанавливается предельный срок тестирования. Все тесты, соответствующие данному компьютеру, должны быть выполнены не позднее указанной даты. Сама дата зависит от тестов, выбранных для каждого конкретного компьютера.
//Большая часть процесса выполнения тестов в компании XYZ автоматизирована при помощи внутреннего программного обеспечения, которое выбирает конкретный набор тестов и определяет дату тестирования на основе типа и функций компьютеров.

public class Main {
    public static void main(String[] args) {
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            if (kSession == null) {
                throw new RuntimeException("KieSession is null. Check kmodule.xml configuration.");
            }

            // Create example computers
            Computer computer1 = new Computer("type 1", null, LocalDate.of(2024, 11, 20), null, null);
            Computer computer2 = new Computer("type 2", "DNS Server", LocalDate.of(2024, 11, 20), null, null);

            // Insert computers into session
            kSession.insert(computer1);
            kSession.insert(computer2);

            // Fire rules
            kSession.fireAllRules();

            // Output results
            System.out.println("------------------------------------------------------");
            System.out.println(computer1);
            System.out.println(computer2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}