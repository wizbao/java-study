package com.abot.common.annotations;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 自定义注解，校验枚举值的有效性
 *
 * @author luoj
 * @date 2020-06-05
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidEnum.Validator.class)
public @interface ValidEnum {

    /**
     * 设置提示消息
     * @return 返回消息内容
     */
    String message() default "无效的枚举值";

    /**
     * 设置枚举值校验的方法名称
     * @return 返回方法名称
     */
    String method() default "isValid";

    /**
     * 分组
     * @return 返回分组的类数组
     */
    Class<?>[] groups() default {};

    /**
     * 负载
     * @return 返回负载的类数组
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * 设置待校验的枚举类
     * @return 返回枚举类
     */
    Class<? extends Enum<?>> clazz();

    /**
     * 内部类实现校验接口
     */
    class Validator implements ConstraintValidator<ValidEnum, Object> {

        /**
         * 枚举类
         */
        private Class<? extends Enum<?>> enumClazz;

        /**
         * 校验枚举值是否有效的方法名称
         */
        private String enumMethod;

        @Override
        public void initialize(ValidEnum validEnum) {
            this.enumClazz = validEnum.clazz();
            this.enumMethod = validEnum.method();
        }

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {
            if (value == null || value.toString().trim().isEmpty()) {
                return true;
            }

            if (enumClazz == null || enumMethod == null || enumMethod.trim().length() == 0) {
                return true;
            }

            Class<?> valClazz = value.getClass();
            try {
                Method methodObj = enumClazz.getMethod(enumMethod, valClazz);
                // 枚举提供的校验方法返回值必须是布尔类型
                if (!Boolean.TYPE.equals(methodObj.getReturnType()) && !Boolean.class.equals(methodObj.getReturnType())) {
                    throw new RuntimeException(String.format("%s method return is not boolean type in the %s class", enumMethod, enumClazz));
                }

                // 枚举提供的校验方法必须为静态方法
                if (!Modifier.isStatic(methodObj.getModifiers())) {
                    throw new RuntimeException(String.format("%s method is not static method in the %s class", enumMethod, enumClazz));
                }

                // 调用枚举的校验方法
                Boolean result = (Boolean) methodObj.invoke(null, value);
                return result != null && result;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(String.format("This %s(%s) method does not exist in the %s", enumMethod, valClazz, enumClazz), e);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
