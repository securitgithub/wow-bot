package org.freekode.wowbot.beans.ai;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.convert.TypeConverters;
import org.freekode.wowbot.tools.StaticFunc;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class InfoAI extends Intelligence<InfoAI.InfoUpdate> {
    private static final Logger logger = LogManager.getLogger(InfoAI.class);


    @Override
    public Boolean processing() throws InterruptedException {
        while (true) {
            Double x = getController().getReceiver().getX();
            Double y = getController().getReceiver().getY();
            Double azimuth = getController().getReceiver().getAzimuth();
            Double pitch = getController().getReceiver().getPitch();
            send(new InfoUpdate(x, y, azimuth, pitch));

            Thread.sleep(200);
        }
    }

    public class InfoUpdate {
        private Double x;
        private Double y;
        private Double azimuth;
        private Double pitch;

        public InfoUpdate(Double x, Double y, Double azimuth, Double pitch) {
            this.x = x;
            this.y = y;
            this.azimuth = azimuth;
            this.pitch = pitch;
        }

        public Double getX() {
            return x;
        }

        public Double getY() {
            return y;
        }

        public Double getAzimuth() {
            return azimuth;
        }

        public Double getPitch() {
            return pitch;
        }
    }
}