package com.kdnakt.sandbox.cron;

import static com.cronutils.model.field.expression.FieldExpressionFactory.*;

import java.time.ZonedDateTime;

import com.cronutils.builder.CronBuilder;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
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
        System.out.println(cron.asString());
        ExecutionTime execTime = ExecutionTime.forCron(cron);
        System.out.println(execTime.nextExecution(ZonedDateTime.now()));
    }

}