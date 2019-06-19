package com.XCCuisine.generator;

import org.mybatis.generator.api.ShellRunner;

/**
 * @ClassName: MybatisGenerator
 * @ClassNameExplain: mybatis 代码生成工具
 */
public class MybatisGeneratorRunner {

    public static void main(String[] args) {
        String config = MybatisGeneratorRunner.class.getClassLoader()
                .getResource("mybatis-generator.xml").getFile();
        String[] arg = { "-configfile", config, "-overwrite" };
        ShellRunner.main(arg);
    }
}
