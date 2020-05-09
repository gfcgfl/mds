package com.zju.nir.report.core;

import com.zju.nir.common.entity.Mark;
import com.zju.nir.common.utils.FileUtils;
import com.zju.nir.report.constant.ReportConstant;
import com.zju.nir.report.entity.BloodoxygenParamDescription;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static com.zju.nir.report.constant.ReportConstant.*;
import static java.awt.BasicStroke.CAP_SQUARE;
import static java.awt.BasicStroke.JOIN_MITER;

/**
 * @author xiaoguo
 */
public class Draw {

    private static int curColor = 0;
    private static Color[] colors = new Color[]{Color.BLACK, Color.RED, Color.BLUE, Color.GREEN,
            Color.ORANGE, Color.MAGENTA};

    //关于画图有关的
    private static Stroke INTERNAL_AXIS_STROKE = new BasicStroke(1.0f,
            CAP_SQUARE, JOIN_MITER, 10.0f, new float[]{10.0f, 5.0f}, 0.0f);

    private static Stroke WAVEFORM_STROKE = new BasicStroke(1.2f,
            CAP_SQUARE, JOIN_MITER, 10.0f, null, 0.0f);

    private static Stroke MARK_STROKE = new BasicStroke(1.5f,
            CAP_SQUARE, JOIN_MITER, 10.0f, null, 0.0f);

    private static Font FONT_TITLE = new Font("黑体", Font.BOLD, 40);
    private static Font FONT_PLAIN = new Font("宋体", Font.PLAIN, 26);
    private static Font FONT_MARK = new Font("黑体", Font.BOLD, 30);

    private static DecimalFormat FORMAT = new DecimalFormat("0.00");


    private BloodoxygenParamDescription paramDescription;

    private float waveformWidth;
    private float waveformHeight;

    private float waveformValueMax;
    private float waveformValueMin;


    public Draw(BloodoxygenParamDescription paramDescription) {
        this.paramDescription = paramDescription;
        //在最大值最小值之外留出一点空间
        float temp = (paramDescription.getUp() - paramDescription.getLow() >= 6) ? 1.0f : 0.2f;
        this.waveformValueMax = paramDescription.getUp() + temp;
        this.waveformValueMin = paramDescription.getLow() - temp;
        Integer count = paramDescription.getCount();
        this.waveformWidth = (count == null || count == 0) ? 0 : count - 1;
        this.waveformHeight = this.waveformValueMax - this.waveformValueMin;
    }


    public File draw() {

        if (this.waveformWidth == 0) {
            return null;
        }
        BufferedImage targetImage = new BufferedImage(REPORT_IMAGE_WIDTH,
                REPORT_IMAGE_HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = targetImage.createGraphics();

        File imgFile = null;
        try {
            setBackGround(g, REPORT_IMAGE_WIDTH, REPORT_IMAGE_HEIGHT);
            drawCoordinates(g);
            drawWaveform(g);
            imgFile = toFile(targetImage);
        } catch (IOException e) {
//            logger.error("名称为\"{}\"的图片创建失败。", this.imgName);
            return null;
        } finally {
            g.dispose();
        }

        return imgFile;
    }

    private void setBackGround(Graphics2D g, int width, int height) {
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, width, height);
    }


    private void drawWaveform(Graphics2D g) {
        g.setStroke(WAVEFORM_STROKE);
        // 每次画图（新的图）的时候重置颜色，只有当一张图里面画多个曲线才区分颜色
        curColor = 0;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        // =============做出数据波形图 及在波形上标注mark的id==============
        float[] paramValues = paramDescription.getParamValues();
        if (paramValues == null || paramValues.length == 0) {
            return;
        }
        Color color = colors[curColor++];
        if (curColor == colors.length) {
            curColor = 0;
        }
        g.setColor(color);
        float pre = paramValues[0];
        List<Mark> marks = paramDescription.getMarks();
        if (marks == null || marks.isEmpty()) {
            // 没有mark信息的时候只画图不进行mark的显示
            for (int i = 1; i < paramValues.length; i++) {
                float cur = paramValues[i];
//                if (pre == null || cur == null) {
//                    continue;
//                }
                int x1Pos = getMappingPointPositionX((float) (i - 1));
                int y1Pos = getMappingPointPositionY(pre);
                int x2Pos = getMappingPointPositionX((float) i);
                int y2Pos = getMappingPointPositionY(cur);
                g.drawLine(x1Pos, y1Pos, x2Pos, y2Pos);
                pre = cur;

            }
        } else {
            Iterator<Mark> iterator = marks.iterator();
            Mark mark = iterator.next();
            for (int i = 1; i < paramValues.length; i++) {
                float cur = paramValues[i];
//                if (pre == null || cur == null) {
//                    continue;
//                }
                int x1Pos = getMappingPointPositionX((float) (i - 1));
                int y1Pos = getMappingPointPositionY(pre);
                int x2Pos = getMappingPointPositionX((float) i);
                int y2Pos = getMappingPointPositionY(cur);
                g.drawLine(x1Pos, y1Pos, x2Pos, y2Pos);
                if (mark != null && i + 1 == mark.getFrameNum()) {
                    //标记mark
                    g.fillOval(x2Pos - 5, y2Pos - 5,
                            10, 10);
                    // 效果的试一试调一调
                    int centerY = y2Pos - Y < 30 ? y2Pos + 25 : y2Pos - 25;
                    drawStringCenterAligned(mark.getMarkId().toString(),
                            FONT_MARK, g, x2Pos, centerY);
                    // 下一个mark
                    mark = iterator.hasNext() ? iterator.next() : null;
                }
                pre = cur;
            }
        }

//            // =============做出标记: 在对应的横轴（帧）上画一个点==============
//            int circleRadius = 5;
//            int circleDiameter = circleRadius << 1;
//            if (this.marks != null && !this.marks.isEmpty()) {
//                g.setStroke(MARK_STROKE);
//                g.setColor(Color.RED);
//
//                for (Mark mark : marks) {
//                    int xPos = getMappingPointPositionX((float) (mark.getFrameNum() - 1));
////                    g.drawLine(xPos, Y, xPos, REPORT_IMAGE_HEIGHT - Y);
//
////                    g.fillOval(xPos - circleRadius, Y - circleRadius, circleDiameter, circleDiameter);
//                    g.fillOval(xPos - circleRadius, REPORT_IMAGE_HEIGHT - Y - circleRadius,
//                            circleDiameter, circleDiameter);
//                    drawStringCenterAligned(mark.getMarkId().toString(),
//                            FONT_MARK, g, xPos, REPORT_IMAGE_HEIGHT - Y - 20);
//                }
//            }
    }

    private void drawCoordinates(Graphics2D g) {

        // ===== 1 画出图的边框========
        int x1 = ReportConstant.X;
        int y1 = REPORT_IMAGE_HEIGHT - Y;
        int x2 = REPORT_IMAGE_WIDTH - ReportConstant.X;
        int y2 = Y;
        // 边界的stroke暂且与波形的相同
        g.setStroke(Draw.WAVEFORM_STROKE);
        g.setColor(Color.BLACK);
        // 四个边
        g.drawLine(x1, y1, x1, y2);
        g.drawLine(x1, y2, x2, y2);
        g.drawLine(x2, y1, x2, y2);
        g.drawLine(x2, y1, x1, y1);
        g.setStroke(Draw.INTERNAL_AXIS_STROKE);

        // ======2 根据横轴宽度，决定竖直的轴线的相邻间的宽度并绘制他们（用细虚线）
        //大概就画20条
        int interval = (int) Math.ceil(this.waveformWidth / 20);
        if (interval % 2 == 1) {
            interval++;    //使得间隔是2的整数倍
        }
        // 需要注意将interval反映到Graphics2D上，得到在Graphics2D上的实际interval，
        // 这里为了方便直接使用getMappingPointPositionX方法
        int mappingPointPositionX = getMappingPointPositionX(0);
        int intervalGraphics2D = getMappingPointPositionX(interval) - mappingPointPositionX;

        for (int i = mappingPointPositionX + intervalGraphics2D;
             i < getMappingPointPositionX(this.waveformWidth);
             i = i + intervalGraphics2D) {

            g.drawLine(i, y1, i, y2);
        }

        // ======3 标注x轴的数值===============================
        // 先标注0
        drawStringCenterAligned("0", Draw.FONT_PLAIN, g,
                mappingPointPositionX, Y_VALUE_OF_X_ANNOTATION);
        // 再标注其他的
        for (int i = mappingPointPositionX + intervalGraphics2D, xValue = interval;
             i < getMappingPointPositionX(this.waveformWidth);
             i += intervalGraphics2D, xValue += interval) {
            //因为实际上数据是每两秒一个，即当横洲上有20个数据的时候，横轴的数值应该到40s
            int realXValue = xValue << 1;
            drawStringCenterAligned(String.valueOf(realXValue), Draw.FONT_PLAIN, g,
                    i, Y_VALUE_OF_X_ANNOTATION);
        }

        // ======4 根据纵轴宽度，决定水平的轴线的相邻间的宽度并绘制他们（用细虚线）
        //大概就画6 7条
        double intervalY = this.waveformHeight / 7;
        // intervalY向上取偶 例如 0.852 -> 0.86   4.52 -> 4.6
        if (this.waveformHeight <= 6.0f) {
            intervalY = Math.ceil(intervalY / 0.01) * 0.01;
        } else {
            intervalY = Math.ceil(intervalY / 0.1) * 0.10;
        }

        int mappingPointPositionY = getMappingPointPositionY(0);

        // 需要注意将interval反映到Graphics2D上，得到在Graphics2D上的实际interval
        intervalGraphics2D = mappingPointPositionY - getMappingPointPositionY((float) intervalY);
        // 从纵坐标的0处开始分别向上向下话水平轴线 （保证轴线代表0.5或者5的倍数处）， 注意在g2d中的纵坐标是反着的
        for (int y = mappingPointPositionY; y > Y; y = y - intervalGraphics2D) {
            if (y >= REPORT_IMAGE_HEIGHT - Y) {
                // 当y的值在规定的画图纵向范围之外时候是不画横向的轴线的
                continue;
            }
            g.drawLine(x1, y, x2, y);
        }
        for (int y = mappingPointPositionY + intervalGraphics2D;
             y < REPORT_IMAGE_HEIGHT - Y;
             y = y + intervalGraphics2D) {
            if (y <= Y) {
                // 当y的值在规定的画图纵向范围之外时候是不画横向的轴线的
                continue;
            }
            g.drawLine(x1, y, x2, y);
        }
        // ======5 标注y轴的数值===============================
        // 先找到0处，并标注0 (如果0不在绘图范围内则不标注)
        if (mappingPointPositionY <= REPORT_IMAGE_HEIGHT - Y
                && mappingPointPositionY >= Y) {
            drawStringCenterAligned("0", FONT_PLAIN, g,
                    X_VALUE_OF_Y_ANNOTATION, mappingPointPositionY);
        }
        double yValue = intervalY;
        for (int y = mappingPointPositionY - intervalGraphics2D;
             y > Y;
             y = y - intervalGraphics2D, yValue += intervalY) {
            if (y >= REPORT_IMAGE_HEIGHT - Y) {
                // 当y的值在规定的画图纵向范围之外时候是不画横向的轴线的
                continue;
            }
            drawStringCenterAligned(FORMAT.format(yValue), FONT_PLAIN, g,
                    X_VALUE_OF_Y_ANNOTATION, y);
        }
        yValue = -intervalY;
        for (int y = mappingPointPositionY + intervalGraphics2D;
             y < REPORT_IMAGE_HEIGHT - Y;
             y = y + intervalGraphics2D, yValue -= intervalY) {
            if (y <= Y) {
                // 当y的值在规定的画图纵向范围之外时候是不画横向的轴线的
                continue;
            }
            drawStringCenterAligned(FORMAT.format(yValue), FONT_PLAIN, g,
                    X_VALUE_OF_Y_ANNOTATION, y);
        }
        // ======6 标题title ===========
        drawStringCenterAligned(paramDescription.getParamFullName(),
                Draw.FONT_TITLE,
                g,
                REPORT_IMAGE_WIDTH / 2,
                ReportConstant.IMG_TITLE_Y);

        // =====7 横纵轴的单位
        // y轴
        drawStringCenterAligned(paramDescription.getUnit(), Draw.FONT_PLAIN, g, X_VALUE_OF_Y_UNIT, Y_VALUE_OF_Y_UNIT);
        drawStringCenterAligned("时间/s", Draw.FONT_PLAIN, g, X_VALUE_OF_X_UNIT, Y_VALUE_OF_X_UNIT);
    }

    private File toFile(BufferedImage targetImage) throws IOException {

        File f = File.createTempFile("tempImage-" + UUID.randomUUID(), "." + ReportConstant.IMG_FILE_EXT_NAME);
        ImageIO.write(targetImage, ReportConstant.IMG_FILE_EXT_NAME, f);
        return f;
    }

    /**
     * 获取映射到的Graphics2D上的点的 x坐标
     */
    private int getMappingPointPositionX(float x) {
        return Math.round(ReportConstant.X
                + x / this.waveformWidth * ReportConstant.WAVEFORM_DISPLAY_AREA_WIDTH);
    }

    /**
     * 获取映射到的Graphics2D上的点的 y坐标
     */
    private int getMappingPointPositionY(float y) {
        // Graphics2D的坐标原点是在左上角，而我们认为的原点是在左下角，对于y轴坐标要修正

        float v = Y
                + (y - this.waveformValueMin) / this.waveformHeight * ReportConstant.WAVEFORM_DISPLAY_AREA_HEIGHT;
        return REPORT_IMAGE_HEIGHT - Math.round(v);
    }


    /**
     * 在x,y处居中显示字符串
     *
     * @param string
     * @param font
     * @param g
     * @param x      Graphics2D中的x坐标值
     * @param y      Graphics2D中的y坐标值
     */
    private void drawStringCenterAligned(String string, Font font, Graphics2D g, int x, int y) {
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics(font);
//            // 计算出中心点 x 位置
//            int centerX = ReportConstant.REPORT_IMAGE_WIDTH / 2;
        // 文字宽度
        int textWidth = fontMetrics.stringWidth(string);
        int textHeight = fontMetrics.getHeight();
        g.drawString(string, x - textWidth / 2, y + textHeight / 2);
    }

}
