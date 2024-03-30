import React, { ComponentProps, PropsWithChildren } from 'react';

interface FormGroupProps extends ComponentProps<'fieldset'> {}

interface FormGroupWithProps extends PropsWithChildren<FormGroupProps> {}

export default function FormGroup({ children, ...props }: FormGroupWithProps) {
  return <fieldset {...props}>{children}</fieldset>;
}
