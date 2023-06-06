## Documentatie proiect final FastTrackIT
Cursanta: Melinda Magyar

Scopul acestui proiect este sa automatizeze testarea site-ului web https://demoqa.com/books  folosind limbajul de programare Java și diverse instrumente de testare.

Framework-ul folosit este Selenium WebDriver, iar testele sunt rulate cu TestNG.

Fisierul **pom.xml** contine toate dependintele Maven care sunt necesare pentru rularea testelor: Selenium, Chrome Driver, TestNG, FireFox Driver.

Proiectul a fost creat folosind design pattern-ul **Page Object Model**, astfel este format din 2 pachete: pages si testCases.

Pachetul **pages** contine locatorii din paginile BookStorePage, LoginPage, RadioButtonPage si TextBoxPage. Contine de asemenea si clasa BasePage care este clasa de baza pentru celelalte clase. Aici am stabilit adresa URL pentru site-ul web testat si configurari comune pentru fiecare clasa:
- prin metoda **@BeforeClass** se deschide o instanta de Google Chrome dupa care se va redirectiona catre site-ul web testat;
- prin metoda **@AfterMethod** se inchide instanta de Chome dupa rularea fiecarui test.

Pachetul **testCases** contine test case-urile aferente elementelor din clasele mentionate in pachetul pages.

Proiectul contine atat scenarii pozitive, prin care am rulat teste folosind date si input-uri valide, cat si scenarii negative, unde am folosit date si input-uri invalide si am verificat prezente unor mesaje de eroare.

TestNG va executa test case-urile pe rand si va genera un raport cu rezultatele testelor:
![Picture1](https://github.com/MelindaM17/FinalProject/assets/132599174/2c4861ac-578d-4722-a9a5-2a1d04d11242)
