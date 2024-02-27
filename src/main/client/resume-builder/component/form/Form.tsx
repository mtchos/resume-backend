import React from 'react';
import { BasicProps } from '@/component/interface/BasicProps';

export default function Form({ children, ...props }: React.PropsWithChildren<BasicProps>) {
  return (
    <form action="" {...props}>
      {children}
    </form>
  );
}
