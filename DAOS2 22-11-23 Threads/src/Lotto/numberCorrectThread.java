package Lotto;

public class numberCorrectThread extends Thread {
    //Fields ---------------------------------------------------------------------------------------------------------
    private lottoraek rigtigeArray;
    private lottoraek[] spilledeArray;
    private int[] antalgev = new int[8];
    private int start;
    private int stop;


    //Constructors ---------------------------------------------------------------------------------------------------
    public numberCorrectThread(lottoraek rigtigeArray, lottoraek[] spilledeArray, int start, int stop ) {
        super();
        this.rigtigeArray = rigtigeArray;
        this.spilledeArray = spilledeArray;
        this.start = start;
        this.stop = stop;
    }

    //Methods - Get, Set & Add ---------------------------------------------------------------------------------------


    //Methods - Other ------------------------------------------------------------------------------------------------
    public void run() {
        for (int i=start; i < stop; i++) {
            antalgev[rigtigeArray.antalrigtige(spilledeArray[i])] ++;
        }


    }

    public int[] getAntalGev () {
        return antalgev;
    }

}
