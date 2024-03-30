import React, { ComponentProps } from 'react';

interface FormInputProps extends ComponentProps<'input'> {}

export default function FormInput({ ...props }: FormInputProps) {
  return <input type="text" placeholder={props.placeholder} {...props} />;
}
