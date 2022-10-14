import { createContext } from "react";
import { PostInfo } from "./PostInfo";

export interface AppContextInterface {
  name: string;
  author: string;
  url: string;
}

export const AppCtx = createContext<AppContextInterface | null>(null);

// Provider in your app

const sampleAppContext: AppContextInterface = {
  name: "Using React Context in a Typescript App",
  author: "thehappybug",
  url: "http://www.example.com",
};

export const ContextApp = () => (
  <AppCtx.Provider value={sampleAppContext}>
    <PostInfo/>
  </AppCtx.Provider>
);