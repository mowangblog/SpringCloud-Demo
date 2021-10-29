package top.mowang.cloud;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * MybatisPlus-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/18 00:57
 **/
public class MybatisPlusAutoGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/cloud?serverTimezone=UTC&CharacterEncoding=utf-8", "root", "lixuan")
                // 全局配置
                .globalConfig((scanner, builder) -> builder
                        .author(scanner.apply("请输入作者名称？"))
                        .fileOverride()
                        .enableSwagger()
                        .commentDate("yyyy-MM-dd")
                )
                // 包配置
                .packageConfig((scanner, builder) -> builder
                                .parent("top.mowang.cloud")
                                .entity("pojo")
                                .service("service")
                                .serviceImpl("service.impl")
                                .mapper("mapper")
                                .controller("controller")
                        )
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder()
                        .enableLombok()
                        .addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        )
                        .build()
                )
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .execute();
    }
    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
