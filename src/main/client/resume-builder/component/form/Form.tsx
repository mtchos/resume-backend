import React, { ComponentProps, PropsWithChildren } from 'react';

interface FormProps extends ComponentProps<'form'> {}

interface FormPropsWithChildren extends PropsWithChildren<FormProps> {}

export default function Form({ children, ...props }: FormPropsWithChildren) {
  return <form {...props}>{children}</form>;
}
