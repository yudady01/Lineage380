/**
 * License
 * THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF THIS
 * CREATIVE COMMONS PUBLIC LICENSE ("CCPL" OR "LICENSE").
 * THE WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW.
 * ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS LICENSE OR
 * COPYRIGHT LAW IS PROHIBITED.
 * <p>
 * BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND
 * AGREE TO BE BOUND BY THE TERMS OF THIS LICENSE. TO THE EXTENT THIS LICENSE
 * MAY BE CONSIDERED TO BE A CONTRACT, THE LICENSOR GRANTS YOU THE RIGHTS CONTAINED
 * HERE IN CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS.
 */
package l1j.server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import l1j.server.server.GameServer;
import l1j.server.telnet.TelnetServer;
import l1j.server.util.InputStreamUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * l1j 伺服器啟動
 */
@SpringBootApplication
public class Server implements CommandLineRunner {
    /**
     * 紀錄用
     */
    private static Logger _log = Logger.getLogger(Server.class.getName());

    /**
     * 紀錄檔的路徑
     */
    private static final String LOG_PROP = "config/log.properties";

    /**
     * サーバメイン.
     *
     * @param args 命令列參數
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
        SpringApplication.run(Server.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        File logFolder = new File("log");
        logFolder.mkdir();

        try {
            // InputStream is = Server.class.getClassLoader().getResourceAsStream(LOG_PROP);
            InputStream is = InputStreamUtil.getInputStreamFromClasspath(LOG_PROP);
            LogManager.getLogManager().readConfiguration(is);
            is.close();
        } catch (IOException e) {
            _log.log(Level.SEVERE, "Failed to Load " + LOG_PROP + " File.", e);
            System.exit(0);
        }
        try {
            Config.load();
        } catch (Exception e) {
            _log.log(Level.SEVERE, e.getLocalizedMessage(), e);
            System.exit(0);
        }

        // L1DatabaseFactory初期設定
        L1DatabaseFactory.setDatabaseSettings(Config.DB_DRIVER, Config.DB_URL, Config.DB_LOGIN, Config.DB_PASSWORD);
        L1DatabaseFactory.getInstance();

        GameServer.getInstance().initialize();
        if (Config.TELNET_SERVER) {
            TelnetServer.getInstance().start();
        }
    }
}
