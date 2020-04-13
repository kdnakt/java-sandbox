package com.kdnakt.sandbox.cron;

import static com.cronutils.model.field.expression.FieldExpressionFactory.always;
import static com.cronutils.model.field.expression.FieldExpressionFactory.between;
import static com.cronutils.model.field.expression.FieldExpressionFactory.on;
import static com.cronutils.model.field.expression.FieldExpressionFactory.questionMark;

import java.time.ZonedDateTime;

import com.cronutils.builder.CronBuilder;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.time.ExecutionTime;

public class CronSample {

    public static void main(String[] args) {
        CronDefinition def = CronDefinitionBuilder
                .instanceDefinitionFor(CronType.QUARTZ);
        Cron cron = CronBuilder.cron(def)
                .withYear(always())
                .withDoM(between(9, 11))
                .withMonth(always())
                .withDoW(questionMark())
                .withHour(always())
                .withMinute(always())
                .withSecond(on(0))
                .instance();
        ZonedDateTime now = ZonedDateTime.parse("2020-04-12T10:15:30+09:00");
        next(cron, now);// 0 * * 9-11 * ? * = 2020-05-09T00:00+09:00

        try {
            // L is only available for CRON4J
            cron = CronBuilder.cron(def)
                   .withDoM(on(SpecialChar.L))
                   .instance();
        } catch (NullPointerException ignore) {
        }

        def = CronDefinitionBuilder.instanceDefinitionFor(CronType.CRON4J);
        cron = CronBuilder.cron(def)
                .withDoM(on(SpecialChar.L))
                .instance();
        next(cron, now);// L = 2020-04-30T00:00+09:00
    }

    static void next(Cron cron, ZonedDateTime now) {
        System.out.println(
                cron.asString()
                + " = "
                + ExecutionTime.forCron(cron).nextExecution(now).get().toString());
    }
}