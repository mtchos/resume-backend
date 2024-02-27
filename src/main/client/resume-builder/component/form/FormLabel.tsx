import React from 'react';
import { BasicProps } from '@/component/interface/BasicProps';

export default function FormLabel({ children, ...props }: React.PropsWithChildren<BasicProps>) {
  return (
    <label htmlFor="" {...props}>
      {children}
    </label>
  );
}
