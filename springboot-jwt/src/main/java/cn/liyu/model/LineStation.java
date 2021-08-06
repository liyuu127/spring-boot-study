package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

@Data
@TableName(value = "line_station")
public class LineStation implements Serializable {
    /**
     * 主健id
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 线路id
     */
    @TableField(value = "line_id")
    private Integer lineId;

    /**
     * 站点id
     */
    @TableField(value = "station_id")
    private Integer stationId;

    /**
     * 序号
     */
    @TableField(value = "sequence_number")
    private Integer sequenceNumber;

    private static final long serialVersionUID = 1L;

    public static final String COL_LINE_ID = "line_id";

    public static final String COL_STATION_ID = "station_id";

    public static final String COL_SEQUENCE_NUMBER = "sequence_number";
}