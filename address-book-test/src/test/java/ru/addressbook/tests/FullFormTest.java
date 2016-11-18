package ru.addressbook.tests;

import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.Arrays;
        import java.util.stream.Collectors;

        import static org.hamcrest.CoreMatchers.equalTo;
        import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by xxmoised on 15.11.2016.
 */
        public class FullFormTest extends TestBase {

          @BeforeMethod
          public void ensurePreconditions() {
              app.contact().ContactPage();
              if (app.contact().all().size()==0){
                  app.contact().initCreationContact();
                  app.contact().createContact((new ContactData()
                          .withFirstname("FirstName")
                          .withLastname("LastName")
                          .withMiddlename("MiddleName")
                          .withAddress("fgbfgbfg")
                          .withEmail1("tests@tests.ru")
                          .withGroup("test1")));
              }
          }

          @Test()
  public void testContactEmails() {
            ContactData contact = app.contact().all().iterator().next();
           ContactData contactInfoFromFullInfoPage = app.contact().infoFromFullInfoPage(contact);
            ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

                    assertThat(cleaned(contactInfoFromFullInfoPage.getAllInfo()), equalTo((mergeFullInfo(contactInfoFromEditForm))));
          }
            private String mergeFullInfo(ContactData contact) {
            ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
         return Arrays.asList(getNameandAddress(contactInfoFromEditForm), getPhones(contactInfoFromEditForm), getEmails(contactInfoFromEditForm))
                            .stream().filter((e) -> ! e.equals(""))
                            .map(FullFormTest::cleaned)
                            .collect(Collectors.joining(" "));
          }

          private String getNameandAddress(ContactData contact) {
            ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
            return Arrays.asList(contactInfoFromEditForm.getFirstname(), contactInfoFromEditForm.getLastname(), contactInfoFromEditForm.getAddress())
                            .stream().filter((n) -> ! n.equals(""))
                            .map(FullFormTest::cleaned)
                            .collect(Collectors.joining(" "));
          }

          private String getPhones(ContactData contact) {
            ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
            return Arrays.asList("H: " + contactInfoFromEditForm.getHomePhone(), "M: " + contactInfoFromEditForm.getMobilePhone(), "W: " + contactInfoFromEditForm.getWorkPhone())
                            .stream().filter((m) -> ! m.equals(""))
                            .map(FullFormTest::cleaned)
                            .collect(Collectors.joining(" "));
          }

          private String getEmails(ContactData contact) {
            ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
            return Arrays.asList(contactInfoFromEditForm.getEmail1() + " (www." + contactInfoFromEditForm.getEmail1().substring(contactInfoFromEditForm.getEmail1().indexOf("@")+1) + ")",
                            contactInfoFromEditForm.getEmail2() + " (www." + contactInfoFromEditForm.getEmail2().substring(contactInfoFromEditForm.getEmail2().indexOf("@")+1) + ")",
                            contactInfoFromEditForm.getEmail3() + " (www." + contactInfoFromEditForm.getEmail3().substring(contactInfoFromEditForm.getEmail3().indexOf("@")+1) + ")")
                           .stream().filter((e) -> ! e.equals(""))
                            .map(FullFormTest::cleaned)
                            .collect(Collectors.joining(" "));
          }

          public static String cleaned(String allInfo) {
            return allInfo.replaceAll("^\\s+", "").replaceAll("\\s+$", "").replaceAll("\\s+", " ").replaceAll("(\\n)+", " ");
          }
}


