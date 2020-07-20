package test.day07_WebTables;

public class WebTablesNotes {
    /*

    WEBTABLES:

        <table>
            <thead></thead>
            <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>

        Order of creating:
            1.create <table>
            2.create <thead>
            3.create <tbody>
            4.create <tr>           ==>table row
            5.create <td>           ==> table data

        P1_LOCATING THE WHOLE TABLE ITSELF
            //table[@class='SampleTable']

        P2_LOCATING ALL THE ROWS IN THE TABLE
            //table[@class='SampleTable']/tbody/tr

        P3_LOCATING ALL OF CELLS IN ALL OF THE ROWS
            //table[@class=‘SampleTable’]/tbody/tr/td

        P4_LOCATE PAUL BROWN FROM THE TABLE
            1. //table[@class='SampleTable']/tbody/tr/td [.='Paul Brown']
            2. //table[@class='SampleTable']/tbody/tr[2]/td[2]

        P5_LOCATE LAS VEGAS FROM THE TABLE
            //table[@class='SampleTable']/tbody/tr[2]/td[7]

        P6_LOCATE STEVE JOHNS FROM THE TABLE WITHOUT TEXT
            //table[@class='SampleTable']/tbody/tr[4]/td[2]

        P7_LOCATE STEVE JOHNS FROM THE TABLE USING TEXT
            //table[@class='SampleTable']/tbody/tr/td[.='Steve Johns']
            //td[.='Steve Johns']

       P8_LOCATE STEVE JOHNS FROM THE TABLE continuing //td[.='Steve Johns']
          1.  //td[.='Steve Johns']/../td[5] ==> we are going back to parent and then locate
          2.  //td[.='Steve Johns']/following-sibling::td[3]

       P9_LOCATE CLARE JEFFERSON CITY FROM THE TABLE
            //td[.='Clare Jefferson']/following-sibling::td[5]
            //td[.='Clare Jefferson']/../td[7]

      P10_LOCATE STEVE JOHNS CKECHBOX FROM THE TABLE
            //td[.='Steve Johns']/../td[..][1]
            //td[.='Steve Johns']/preceding-sibling::td

     /following-sibling::tagName -> this will only go to the siblings that is AFTER
     /preceding-sibling::tagName -> this will only go to the siblings that is BEFORE










     */

}
