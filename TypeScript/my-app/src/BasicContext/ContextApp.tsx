import React, { createContext, FC, useContext } from "react";

export interface AppContextInterface {
  name: string;
  author: string;
  url: string;
}

export const AppCtx = createContext<AppContextInterface | null>(null);

interface PostInfoProps {
}

export const PostInfo = (props: PostInfoProps): JSX.Element => {
  const appContext = useContext(AppCtx);
  return (
    <div>
      Name: {appContext?.name}, Author: {appContext?.author}, Url:{" "}
      {appContext?.url}
    </div>
  );
};

// Provider in your app

const sampleAppContext: AppContextInterface = {
  name: "Using React Context in a Typescript App",
  author: "thehappybug",
  url: "http://www.example.com",
};

export const ContextApp: FC<{ Comp: FC<PostInfoProps> }> = ({ Comp }) => (
  <AppCtx.Provider value={sampleAppContext}>
    <Comp />
  </AppCtx.Provider>
);
