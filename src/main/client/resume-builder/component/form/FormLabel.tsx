import React, { ComponentProps, PropsWithChildren } from 'react';

interface FormLabelProps extends ComponentProps<'label'> {}

interface FormLabelPropsWithChildren extends PropsWithChildren<FormLabelProps> {}

export default function FormLabel({ children, ...props }: FormLabelPropsWithChildren) {
  return (
    <label htmlFor="" {...props}>
      {children}
    </label>
  );
}
