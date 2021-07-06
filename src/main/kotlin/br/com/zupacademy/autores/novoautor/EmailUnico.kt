package br.com.zupacademy.autores.novoautor

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton
import javax.validation.Constraint

@MustBeDocumented
@Target(AnnotationTarget.FIELD, AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [EmailUnicoValidator::class])
annotation class EmailUnico(
    val message: String = "email já cadastrado para o autor!"
)

@Singleton
class EmailUnicoValidator(val autorRepository: AutorRepository) : ConstraintValidator<EmailUnico, String> {
    override fun isValid(
        value: String?,
        annotationMetadata: AnnotationValue<EmailUnico>,
        context: ConstraintValidatorContext
    ): Boolean {
        if (value == null) {
            return true
        }

        val possivelAutor = autorRepository.findByEmail(value)

        return possivelAutor.isEmpty
    }

}
