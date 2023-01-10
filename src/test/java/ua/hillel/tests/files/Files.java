package ua.hillel.tests.files;

import org.testng.annotations.Test;
import ua.hillel.tests.Base.BaseTest;
import java.io.IOException;

public final class Files extends BaseTest{
    @Test
    public void downloadFile() throws IOException {
        openMainPageTheInternetSite().goToDownloadPage()
                .downloadTxtFile();
        fileModification();

    }
    @Test
    public void uploadFile() throws InterruptedException {
        waitForPreparation();
        openMainPageTheInternetSite().goToUploadPage()
                .uploadFile();

    }
}
