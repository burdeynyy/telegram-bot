export interface Message {
    id: number;
    content: string;
    chatId: number;
    repliedMessage?: number;
    botAnswer?: boolean;
    creationDate?: string;
}
