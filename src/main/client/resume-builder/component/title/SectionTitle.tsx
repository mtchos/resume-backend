import React from 'react';
import { BasicProps } from '@/component/interface/BasicProps';

export default function SectionTitle({ children, ...props }: React.PropsWithChildren<BasicProps>) {
  return (
    <h3 className="font-sans font-bold text-2xl" {...props}>
      {children}
    </h3>
  );
}
